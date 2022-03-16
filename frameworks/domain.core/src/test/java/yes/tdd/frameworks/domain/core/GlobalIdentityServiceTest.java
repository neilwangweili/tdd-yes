package yes.tdd.frameworks.domain.core;

import org.junit.jupiter.api.Test;
import yes.tdd.framewors.domain.core.GlobalIdentityService;
import yes.tdd.framewors.domain.core.GlobalIdentityServiceResetter;
import yes.tdd.framewors.domain.core.UuidBasedIdentityService;

import static org.assertj.core.api.Assertions.assertThat;

public class GlobalIdentityServiceTest {
    @Test
    void should_be_able_to_generate_identities_from_underlying_identity_service() {
        GlobalIdentityServiceResetter.reset(new UuidBasedIdentityService());
        assertThat(GlobalIdentityService.next()).hasSize(32);
        assertThat(GlobalIdentityService.nextReadable()).hasSize(18);
    }
}
