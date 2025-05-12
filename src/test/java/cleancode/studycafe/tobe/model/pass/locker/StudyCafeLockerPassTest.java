package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("StudyCafeLockerPass - 개별 필드 비교 테스트")
class StudyCafeLockerPassTest {

    @Test
    @DisplayName("패스 타입이 동일하면 true를 반환한다")
    void isSamePassType_같은타입이면true() {
        // Given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 20_000);

        // When
        boolean result = lockerPass.isSamePassType(StudyCafePassType.FIXED);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("이용 기간이 동일하면 true를 반환한다")
    void isSameDuration_같은기간이면true() {
        // Given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 14, 15_000);

        // When
        boolean result = lockerPass.isSameDuration(14);

        // Then
        assertThat(result).isTrue();
    }
}