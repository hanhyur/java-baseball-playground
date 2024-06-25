package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("Set 자료구조는 중복을 허용하지 않는다.")
  @Test
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @Test
  void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @ParameterizedTest
  @MethodSource("provideIntegers")
  void parameterizedTest(Integer number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  private static Stream<Integer> provideIntegers() {
    return Stream.of(1, 2, 3);
  }

  @ParameterizedTest
  @MethodSource("provideArguments")
  void failParameterizedTest(Integer number, boolean expected) {
    assertThat(numbers.contains(number)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideArguments() {
    return Stream.of(
        Arguments.of(1, true),
        Arguments.of(2, true),
        Arguments.of(3, true),
        Arguments.of(4, false),
        Arguments.of(5, false)
    );
  }
}
