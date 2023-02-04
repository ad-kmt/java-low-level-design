package org.kmt.design_patterns.behavorial.state.states;

import org.kmt.design_patterns.behavorial.state.MediaPlayer;

public class LockedState extends State {

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     * Here Context = Media Player
     *
     * @param player
     */
    LockedState(MediaPlayer player) {
        super(player);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
