package kitchenpos.common.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DisplayedName {

    @Column(name = "displayed_name", nullable = false)
    private String value;

    protected DisplayedName() {
    }

    public DisplayedName(final String value, final Profanities profanities) {
        validate(value, profanities);
        this.value = value;
    }

    private void validate(final String value, final Profanities profanities) {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 또는 비어있을 수 없습니다.");
        }

        if (profanities.contains(value)) {
            throw new IllegalArgumentException("이름에는 비속어가 포함될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DisplayedName that = (DisplayedName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}