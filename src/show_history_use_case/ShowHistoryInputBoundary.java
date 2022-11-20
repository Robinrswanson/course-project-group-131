package show_history_use_case;
//if we only have one user interface(view), we need to consider this, otherwise ignore
public interface ShowHistoryInputBoundary {
    ShowHistoryFinalInput show(ShowHistoryStartInput startinput);
}
