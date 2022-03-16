package CardProgram;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBLSessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Sessions {
    @Id
    int session_number;
    // Account name

    // Time
}
