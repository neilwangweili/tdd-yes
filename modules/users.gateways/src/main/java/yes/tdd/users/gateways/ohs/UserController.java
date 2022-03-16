package yes.tdd.users.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import yes.tdd.users.application.*;
import yes.tdd.users.application.vo.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Resource SearchUserUseCase searchUserUseCase;
    private @Resource CreateUserUseCase createUserUseCase;
    private @Resource SearchAllUsersUseCase searchAllUsersUseCase;

    @GetMapping("/all")
    public UserOutputs fetchAllUsers() {
        return searchAllUsersUseCase.execute();
    }

    @GetMapping("/{id}")
    public UserOutput getById(@PathVariable String id) {
        return searchUserUseCase.execute(id);
    }

    @PostMapping
    public String register(@RequestBody UserInput user) {
        return createUserUseCase.execute(user);
    }
}