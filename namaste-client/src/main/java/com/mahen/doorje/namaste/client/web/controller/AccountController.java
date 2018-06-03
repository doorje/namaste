package com.mahen.doorje.namaste.client.web.controller;

import com.mahen.doorje.namaste.client.web.dto.NamasteAccountDto;
import com.mahen.doorje.namaste.client.api.namaste.NamasteRegClient;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {

    private static String authorizationRequestBaseUri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private NamasteRegClient namaste;

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(),
                        authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);

        return "login";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("account", new NamasteAccountDto());
        return "join";
    }

    @PostMapping("/join")
    public String createAccount(@ModelAttribute("account") @Valid NamasteAccountDto account, BindingResult result) {

        if(result.hasErrors()) {
            return "join";
        }

        if (EmailExists(account.getEmail())) {
            result.rejectValue("email", "message.emailExistsError");
            return "join";
        }

        Response response = namaste.createAccount(account);
        if (response.status() == HttpStatus.CREATED.value()) {
            return "confirm";
        }

        return "join";
    }

    private boolean EmailExists(String email) {
        if(namaste.emailExists(email).status() == HttpStatus.OK.value()) {
            return true;
        }
        return  false;
    }
}
