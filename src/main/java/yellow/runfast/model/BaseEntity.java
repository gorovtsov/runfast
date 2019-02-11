package yellow.runfast.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abstract entity with uuid.
 *
 * <p>Must to be implemented by any {@link javax.persistence.Entity} class</p>
 *
 * @author Alexander Gorovtsov
 */
@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
