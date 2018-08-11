package pzinsta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderItem implements Serializable {
	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	private Long id;

    @NotNull
	private Long pizzaId;

    @NotNull
    @Min(1)
	private int quantity;

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
    }

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OrderItem)) return false;
		OrderItem orderItem = (OrderItem) o;
		return getQuantity() == orderItem.getQuantity() &&
				Objects.equals(getPizzaId(), orderItem.getPizzaId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPizzaId(), getQuantity());
	}
}