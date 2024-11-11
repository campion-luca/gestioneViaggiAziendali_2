package lucacampion.gestioneViaggiAziendali.payloads;
import lombok.Getter;


@Getter
public class NuovaPrenotazionePayload {
    private int dipendenteId;
    private int viaggioId;
    private String noteAggiunte;
}
