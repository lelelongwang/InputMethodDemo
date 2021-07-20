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
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.TextView;

/**
 * @author Admitor
 * <p>
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
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged: ");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public View onCreateExtractTextView() {
        Log.d(TAG, "onCreateExtractTextView: ");
        return super.onCreateExtractTextView();
    }

    @Override
    public View onCreateCandidatesView() {
        Log.d(TAG, "onCreateCandidatesView: ");
        if (mCandidatesViewRoot == null) {
            mCandidatesViewRoot = LayoutInflater.from(this).inflate(R.layout.candidatesiew_layout, null);

            mCandidateText = (TextView) mCandidatesViewRoot.findViewById(R.id.candidates_text);
            mCandidateText.setVisibility(View.INVISIBLE);
            setCandidatesViewShown(true);
        }
        return mCandidatesViewRoot;
    }

    @Override
    public View onCreateInputView() {
        Log.d(TAG, "onCreateInputView: ");
        mKeyboardBaseView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.keyboard_base, null);
        mKeyboardView = mKeyboardBaseView.findViewById(R.id.keyboardview);
        mKeyboard = new Keyboard(this, R.xml.keyboard_26_eng);
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setPreviewEnabled(true);
        mKeyboardView.setOnKeyboardActionListener(keyboardListener);
        mCurrentInputConnection = getCurrentInputConnection();
        return mKeyboardBaseView;
    }

    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        Log.d(TAG, "onStartInput: ");
        super.onStartInput(attribute, restarting);
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        Log.d(TAG, "onStartInputView: ");
        super.onStartInputView(info, restarting);
    }

    @Override
    public void onFinishInputView(boolean finishingInput) {
        Log.d(TAG, "onFinishInputView: ");
        super.onFinishInputView(finishingInput);
    }

    @Override
    public void onFinishInput() {
        Log.d(TAG, "onFinishInput: ");
        super.onFinishInput();
    }

    @Override
    public void onFinishCandidatesView(boolean finishingInput) {
        Log.d(TAG, "onFinishCandidatesView: ");
        super.onFinishCandidatesView(finishingInput);
    }

    @Override
    public void onDisplayCompletions(CompletionInfo[] completions) {
        Log.d(TAG, "onDisplayCompletions: ");
        super.onDisplayCompletions(completions);
    }

    @Override
    public void requestHideSelf(int flags) {
        Log.d(TAG, "requestHideSelf: ");
        super.requestHideSelf(flags);
    }

    @Override
    public void onWindowShown() {
        Log.d(TAG, "onWindowShown: ");
        super.onWindowShown();
    }

    @Override
    public void onWindowHidden() {
        Log.d(TAG, "onWindowHidden: ");
        super.onWindowHidden();
    }

    @Override
    public void onUpdateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd,
                                  int candidatesStart, int candidatesEnd) {
        Log.d(TAG, "onUpdateSelection: ");
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd, candidatesStart,
            candidatesEnd);
    }

    @Override
    public void onViewClicked(boolean focusChanged) {
        Log.d(TAG, "onViewClicked: ");
        super.onViewClicked(focusChanged);
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
    public void onUpdateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        Log.d(TAG, "onUpdateCursorAnchorInfo: ");
        super.onUpdateCursorAnchorInfo(cursorAnchorInfo);
    }

    @Override
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        Log.d(TAG, "onCurrentInputMethodSubtypeChanged: ");
        super.onCurrentInputMethodSubtypeChanged(newSubtype);
    }

    @Override
    public void onBindInput() {
        Log.d(TAG, "onBindInput: ");
        super.onBindInput();
    }

    @Override
    public void onUnbindInput() {
        Log.d(TAG, "onUnbindInput: ");
        super.onUnbindInput();
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
            Log.d(TAG, "onText: text=" + text);
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
