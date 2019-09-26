package com.longjunhao.inputmethoddemo;

import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.TextView;


/**
 *
 * 参考博客：
 * https://www.cnblogs.com/jason-star/archive/2012/12/13/2816140.html
 * http://www.voidcn.com/article/p-kansqoft-bth.html
 * https://cloud.tencent.com/developer/article/1384966
 */
public class InputMethodDemoService extends InputMethodService {

    private static final String TAG = "InputMethodDemoService";
    private ViewGroup mKeyboardBaseView;
    private KeyboardView mKeyboardView;
    private Keyboard mKeyboard;
    private InputConnection mCurrentInputConnection;
    private View mCandidatesViewRoot;
    private TextView mCandidateText;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public View onCreateInputView() {
        Log.d(TAG, "onCreateInputView: ");
        mKeyboardBaseView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.keyboard_base,null);
        mKeyboardView = mKeyboardBaseView.findViewById(R.id.keyboardview);
        mKeyboard = new Keyboard(this,R.xml.keyboard_26_eng);
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setPreviewEnabled(true);
        mKeyboardView.setOnKeyboardActionListener(keyboardListener);
        mCurrentInputConnection = getCurrentInputConnection();
        return mKeyboardBaseView;
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        super.onStartInputView(info, restarting);
        Log.d(TAG, "onStartInputView: ");
    }

    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInput(attribute, restarting);
        Log.d(TAG, "onStartInput: ");
    }

    @Override
    public void onFinishInput() {
        super.onFinishInput();
        Log.d(TAG, "onFinishInput: ");
    }

    @Override
    public void onWindowShown() {
        super.onWindowShown();
        Log.d(TAG, "onWindowShown: ");
    }

    @Override
    public void onWindowHidden() {
        super.onWindowHidden();
        Log.d(TAG, "onWindowHidden: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onViewClicked(boolean focusChanged) {
        super.onViewClicked(focusChanged);
        Log.d(TAG, "onViewClicked: ");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown: ");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyUp: ");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyLongPress: ");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        Log.d(TAG, "onKeyMultiple: ");
        return super.onKeyMultiple(keyCode, count, event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    @Override
    public void onUpdateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        super.onUpdateCursorAnchorInfo(cursorAnchorInfo);
        Log.d(TAG, "onUpdateCursorAnchorInfo: ");
    }

    @Override
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        super.onCurrentInputMethodSubtypeChanged(newSubtype);
        Log.d(TAG, "onCurrentInputMethodSubtypeChanged: ");
    }

    @Override
    public void onUpdateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd,
                                  int candidatesStart, int candidatesEnd) {
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd, candidatesStart,
                candidatesEnd);
        Log.d(TAG, "onUpdateSelection: ");
    }

    @Override
    public void onBindInput() {
        super.onBindInput();
        Log.d(TAG, "onBindInput: ");
    }

    @Override
    public void onUnbindInput() {
        super.onUnbindInput();
        Log.d(TAG, "onUnbindInput: ");
    }

    @Override
    public View onCreateCandidatesView() {
        if (mCandidatesViewRoot == null) {
            mCandidatesViewRoot = LayoutInflater.from(this).inflate(R.layout.candidatesiew_layout,null);

            mCandidateText = (TextView)mCandidatesViewRoot.findViewById(R.id.candidates_text);
            mCandidateText.setVisibility(View.INVISIBLE);
            setCandidatesViewShown(true);
        }
        return mCandidatesViewRoot;
    }

    private KeyboardView.OnKeyboardActionListener keyboardListener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void onPress(int primaryCode) {
            Log.d(TAG, "onPress: ");

        }

        @Override
        public void onRelease(int primaryCode) {
            Log.d(TAG, "onRelease: ");

        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Log.d(TAG, "onKey: ");
            //mCurrentInputConnection.commitText()
            char ch = (char) primaryCode;
            mCandidateText.setVisibility(View.VISIBLE);
            mCandidateText.setText(String.valueOf(ch));
            InputMethodDemoService.this.sendKeyChar(ch);
        }

        @Override
        public void onText(CharSequence text) {
            Log.d(TAG, "onText: text="+text);
        }

        @Override
        public void swipeLeft() {
            Log.d(TAG, "swipeLeft: ");

        }

        @Override
        public void swipeRight() {
            Log.d(TAG, "swipeRight: ");

        }

        @Override
        public void swipeDown() {
            Log.d(TAG, "swipeDown: ");

        }

        @Override
        public void swipeUp() {
            Log.d(TAG, "swipeUp: ");

        }
    };
}
