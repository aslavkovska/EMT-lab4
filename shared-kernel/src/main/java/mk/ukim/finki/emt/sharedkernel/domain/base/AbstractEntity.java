package mk.ukim.finki.emt.sharedkernel.domain.base;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@MappedSuperclass
@Getter
public class AbstractEntity<ID extends DomainObjectId> {

    @EmbeddedId
    private ID id;

    protected AbstractEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id, "Id must not be null");
    }

    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        this.id = Objects.requireNonNull(source.id, "Id must not be null");
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
