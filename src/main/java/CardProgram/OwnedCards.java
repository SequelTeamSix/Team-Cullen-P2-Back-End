package CardProgram;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OwnedCards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OwnedCards {
    @Id
    public int set_id;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "card_id")
    public Card card;
    // This should be the right relationship type, as each player should appear several times
    // on the table, I just don't feel 100% sure on it right now.
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "player_id")
    public Player player;
    @Column
    public int quantitiy;

}
