package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("StudyCafeSeatPass - 좌석 이용권 로직 테스트")
class StudyCafeSeatPassTest {

    @Test
    @DisplayName("지정된 할인율에 따라 할인 금액이 정확히 계산된다")
    void getDiscountPrice_할인적용정확() {
        // Given
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 7, 50_000, 0.2); // 할인율 20%

        // When
        int discountPrice = pass.getDiscountPrice(); // 예상 할인 금액: 50,000 * 0.2 = 10,000

        // Then
        assertThat(discountPrice).isEqualTo(10_000);
    }


    @Test
    @DisplayName("시간제 패스는 락커를 사용할 수 없도록 제한된다")
    void cannotUseLocker_시간제는true() {
        // Given
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 3, 10_000, 0);

        // When
        boolean result = pass.cannotUseLocker();

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("패스 타입과 기간이 락커 패스와 일치하면 true를 반환한다")
    void isSameDurationType_패스타입과기간일치시true() {
        // Given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 30, 100_000, 0);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 20_000);

        // When
        boolean result = seatPass.isSameDurationType(lockerPass);

        // Then
        assertThat(result).isTrue();
    }
}