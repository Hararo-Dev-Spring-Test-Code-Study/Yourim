package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.*;
import cleancode.studycafe.tobe.model.pass.locker.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.Optional;

@DisplayName("StudyCafePassOrder - 통합 가격 계산 테스트")
class StudyCafePassOrderTest {

    @Test
    @DisplayName("좌석 패스와 락커 패스를 합산하고 할인 금액을 적용하여 총 금액을 계산한다")
    void getTotalPrice_좌석락커할인적용() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 30, 100_000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 20_000);

        // When
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);
        int totalPrice = order.getTotalPrice();

        // Then
        assertThat(totalPrice).isEqualTo(110_000);
    }

    @Test
    @DisplayName("락커 패스가 없을 경우 Optional.empty를 반환한다")
    void getLockerPass_null이면Optional비어있음() {
        // Given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 5, 10_000, 0);
        StudyCafeLockerPass lockerPass = null;

        // When
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);
        Optional<StudyCafeLockerPass> result = order.getLockerPass();

        // Then
        assertThat(result).isEmpty();
    }
}