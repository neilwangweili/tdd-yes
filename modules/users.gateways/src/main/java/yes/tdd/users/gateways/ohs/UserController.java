package yes.tdd.users.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import yes.tdd.users.application.SearchUserUseCase;
import yes.tdd.users.application.vo.UserOutput;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Resource SearchUserUseCase searchUserUseCase;

    @GetMapping("/{id}")
    public UserOutput getById(@PathVariable String id) {
        return searchUserUseCase.execute(id);
    }
}
