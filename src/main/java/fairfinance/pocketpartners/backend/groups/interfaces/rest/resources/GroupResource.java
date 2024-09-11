package fairfinance.pocketpartners.backend.groups.interfaces.rest.resources;

public record GroupResource (Long id, String name, java.util.Set<fairfinance.pocketpartners.backend.groups.domain.model.entities.Currency> currency, String groupPhoto, java.util.Date createdAt, java.util.Date updatedAt) {
}