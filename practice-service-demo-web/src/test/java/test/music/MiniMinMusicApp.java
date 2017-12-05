package test.music;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * @author songwanke
 * @date 2017/12/4
 */
public class MiniMinMusicApp {
    public static void main(String[] args) {
        MiniMinMusicApp mini = new MiniMinMusicApp();
//        System.out.println("\a");
        mini.play();
    }

    public void play() {
        try {
            //取得Sequener并将其打开
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence sep = new Sequence(Sequence.PPQ, 4);
            //取得track
            Track track = sep.createTrack();
            // 执行的内容
            ShortMessage a = new ShortMessage();
            /**
             * 144:信息的类型，144代表Note on
             * 1:频道，每个频道代表不同的演奏者
             * 44：音符，0~127代表不同的音高
             * 100：音道
             *
             */
            a.setMessage(192, 1, 102, 100);
            //MidiEvent是组合乐曲的指令（执行的时机）,在第一拍启动a这个message
            MidiEvent noteOn = new MidiEvent(a, 1);
            /**
             * Track带有全部的MidiEvent对象，
             * Sequence会根据事件时间组织他们，然后Sequence会根据此顺序来播放,
             *同一时间可以执行多个操作
             */
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            a.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(sep);
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
