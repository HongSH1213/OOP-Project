package model;

public class ComponentName {

    public int getFrameCnt() {
        return frameCnt;
    }

    public int getButtonCnt() {
        return buttonCnt;
    }

    public int getLabelCnt() {
        return labelCnt;
    }

    public void plusFrameCnt() {
        ++frameCnt;
    }

    public void plusButtonCnt() {
        ++buttonCnt;
    }

    public void plusLabelCnt() {
        ++labelCnt;
    }

    public void disFrameCnt() {
        --frameCnt;
    }

    public void disButtonCnt() {
        --buttonCnt;
    }

    public void disLabelCnt() {
        --labelCnt;
    }

    public void setFrameCnt(int cnt) {
        frameCnt = cnt;
    }

    public void setButtonCnt(int cnt) {
        buttonCnt = cnt;
    }

    public void setLabelCnt(int cnt) {
        labelCnt = cnt;
    }

    private int frameCnt = 0;
    private int buttonCnt = 0;
    private int labelCnt = 0;

}
