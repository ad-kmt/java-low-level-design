package org.kmt.design_patterns.behavorial.state.states;

import org.kmt.design_patterns.behavorial.state.MediaPlayer;

/**
 * Common interface for all states.
 */
public abstract class State {
    MediaPlayer player;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     * Here Context = Player
     */
    State(MediaPlayer player){
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
