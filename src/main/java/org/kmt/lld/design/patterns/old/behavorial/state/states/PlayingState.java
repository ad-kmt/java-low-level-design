package org.kmt.lld.design.patterns.old.behavorial.state.states;

import org.kmt.lld.design.patterns.old.behavorial.state.MediaPlayer;

public class PlayingState extends State {
    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     * Here Context = Player
     *
     * @param player
     */
    PlayingState(MediaPlayer player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
