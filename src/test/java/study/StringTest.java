package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String actual = "1,2";
        String[] split = actual.split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    void split_2() {
        String actual = "1";
        String[] split = actual.split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    void subString() {
        String actual = "(1,2)";

        int leftIndex = actual.indexOf("(");
        int rightIndex = actual.indexOf(")");

        String substring = actual.substring(leftIndex + 1, rightIndex);

        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    @ParameterizedTest
    @MethodSource("providedArguments")
    void charAt(int index, char expected) {
        String actual = "abc";
        assertThat(actual.charAt(index)).isEqualTo(expected);
    }

    private static Stream<Arguments> providedArguments() {
        return Stream.of(
            Arguments.of(0, 'a'),
            Arguments.of(1, 'b'),
            Arguments.of(2, 'c')

        );
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAtException() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
