package com.inquisitive.userservice.controller;

import com.inquisitive.userservice.model.Account;
import com.inquisitive.userservice.model.Address;
import com.inquisitive.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ankitmishra on 26/01/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        String res = "Hello World";
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(res, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getUser(@PathVariable(value = "id") Long accountId){
        return new ResponseEntity<>(userRepository.getOne(accountId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> createUser(@Valid @RequestBody Account account){
        Account result = userRepository.save(account);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Account> updateUser(@Valid @RequestBody Account account){
        Account oldAccount = userRepository.getOne(account.getId());
        getUpdatedAccount(oldAccount,account);
        Account result =userRepository.save(account);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteUser(@PathVariable(value = "id") Long accountId){
        Account acc = userRepository.getOne(accountId);
        userRepository.delete(acc);
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }

    private void getUpdatedAccount(Account oldAccount,Account updatedAccount){
        if(updatedAccount.getAddress() !=null){
            Address updatedAdd = updatedAccount.getAddress();
            Address oldAdd = oldAccount.getAddress();
            oldAdd.setAddressLine1(updatedAdd.getAddressLine1());
            oldAdd.setAddressLine2(updatedAdd.getAddressLine2());
            oldAdd.setCity(updatedAdd.getCity());
            oldAdd.setCountry(updatedAdd.getCountry());
            oldAdd.setPinCode(updatedAdd.getPinCode());
            oldAccount.setAddress(oldAdd);
        }
        if(updatedAccount.getEmail()!=null){
            oldAccount.setEmail(updatedAccount.getEmail());
        }
        if(updatedAccount.getName()!=null){
            oldAccount.setName(updatedAccount.getName());
        }
        if(updatedAccount.getPassword()!=null){
            oldAccount.setPassword(updatedAccount.getPassword());
        }
        if(updatedAccount.getRole()!=null){
            oldAccount.setRole(updatedAccount.getRole());
        }
        if(updatedAccount.getPhone()!=null){
            oldAccount.setPhone(updatedAccount.getPhone());
        }
    }
}
