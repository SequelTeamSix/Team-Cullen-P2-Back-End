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
@Table(name="Decks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Deck {

    @Id
    public int deck_id;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "player_id")
    public Player owner;

    // This is where it gets tricky. I was originally planning on having 40 columns with each
    // representing
}
