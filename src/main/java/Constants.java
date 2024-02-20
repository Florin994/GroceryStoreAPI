import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Constants {
    BASE_URL("https://simple-grocery-store-api.glitch.me"),
    TOKEN ("74efbe98eadf37ede6d4f6f423e6a4831952bfe2ec025b7ade5433dcb400c64a");
    private final String value;
}
