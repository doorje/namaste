package com.mahen.doorje.namaste.account.web;

import com.mahen.doorje.namaste.account.api.CreateNamasteAccountCommand;
import com.mahen.doorje.namaste.account.query.NamasteAccountEntry;
import com.mahen.doorje.namaste.account.query.NamasteAccountRepository;
import com.mahen.doorje.namaste.account.web.dto.NamasteAccountDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class NamasteAccountRestController {

    private final CommandGateway commandGateway;
    private final NamasteAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public NamasteAccountRestController(CommandGateway commandGateway, NamasteAccountRepository accountRepository) {
        this.commandGateway = commandGateway;
        this.accountRepository = accountRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Resources<NamasteAccountResource>> getAccounts() {
        List<NamasteAccountResource> accountResourceList = accountRepository
                .findAllByOrderByIdAsc().stream()
                .map(NamasteAccountResource::new)
                .collect(Collectors.toList());

        Resources<NamasteAccountResource> resources = new Resources<NamasteAccountResource>(accountResourceList);
        resources.add(linkTo(methodOn(NamasteAccountRestController.class).getAccounts()).withSelfRel());

        return ResponseEntity.ok(resources);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    ResponseEntity<NamasteAccountResource> getAccount(@PathVariable String accountId) {
        return accountRepository
                .findByAccountId(accountId)
                .map(account -> ResponseEntity.ok(new NamasteAccountResource(account)))
                .orElseThrow(() -> new NamasteAccountNotFoundException(accountId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    ResponseEntity<?> create(@RequestBody NamasteAccountDto accountDto) {
        String id = UUID.randomUUID().toString();
        CreateNamasteAccountCommand command =
                new CreateNamasteAccountCommand(id , accountDto.getEmail(), passwordEncoder.encode(accountDto.getPassword()));

        commandGateway.send(command);

        NamasteAccountEntry accountEntry = this.accountRepository.findByAccountId(id).get();
        Link link = new NamasteAccountResource(accountEntry).getLink(Link.REL_SELF);

        return ResponseEntity.created(URI.create(link.getHref())).build();
    }
}
