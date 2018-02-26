package com.example.administrator.expresss.activity.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.expresss.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
//    private ImageHandler mHandler = new ImageHandler(new WeakReference<MainActivity>(this));
//    private ViewPager mViewPager;
//    private TextView text_1,text_2,text_3;
//    private LinearLayout menu_main_shouye;
//
//    private String textContent[];
//    List<String> list=new ArrayList<>();
//    // 自定义轮播图的资源
//    private int[] mImageResIds = {R.drawable.back_bg,R.drawable.edit_bg,R.drawable.help};
//    // 放轮播图片的ImageView 的list
//    private List<ImageView> mImageList = new ArrayList<ImageView>();
//    // 放圆点的View的list
//    private List<View> mDotList = new ArrayList<View>();
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        list.add("123456");
//        list.add("456789");
//        list.add("78915551");
//        initViews();
//        changeTextContent();
//        menu_main_shouye=(LinearLayout)findViewById(R.id.menu_main_shouye);
//        menu_main_shouye.setOnClickListener(this);
    }
//
//    /**
//     *修改滚动通知内容
//     */
//    private void changeTextContent() {
//        text_1=(TextView)findViewById(R.id.tv_text1);
//        text_2=(TextView)findViewById(R.id.tv_text2);
//        text_3=(TextView)findViewById(R.id.tv_text3);
//        for (int i=0;i<list.size();i++){
//            switch (i){
//                case 0:
//                    text_1.setText(String.valueOf(list.get(i)));
//                    break;
//                case 1:
//                    text_2.setText(String.valueOf(list.get(i)));
//                    break;
//                case 2:
//                    text_3.setText(String.valueOf(list.get(i)));
//                    break;
//            }
//        }
//    }
//
//    private void initViews() {
//        // 初始化iewPager的内容
//        mViewPager = (ViewPager) findViewById(R.id.view_pager);
//        LinearLayout dotLayout = (LinearLayout) findViewById(R.id.dotLayout);
//        dotLayout.removeAllViews();
//        for (int i = 0; i < mImageResIds.length; i++) {
//            ImageView imageView = new ImageView(MainActivity.this);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            // view.setTag(mImageResId[i]);
//            imageView.setImageResource(mImageResIds[i]);
//            mImageList.add(imageView);
//
//            View dotView = new View(MainActivity.this);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( 50,50);
////            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.dot_width),
////                    getResources().getDimensionPixelSize(R.dimen.dot_width));
//            params.setMargins(4, 0, 4, 0);
//            dotView.setLayoutParams(params);
//            dotLayout.addView(dotView);
//            mDotList.add(dotView);
//        }
//        mViewPager.setAdapter(new ImageAdapter(mImageList));
//        mViewPager.setOnPageChangeListener(new PageChangeListener());
//        mViewPager.setFocusable(true);
//        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2);// 默认在中间，使用户看不到边界
//        mViewPager.setOnTouchListener(this);
//        // 开始轮播效果
//        mHandler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
//    }
//
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                mHandler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                mHandler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
//                break;
//        }
//        return false;
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.menu_main_shouye:
//                break;
//        }
//    }
//
//    private class PageChangeListener implements ViewPager.OnPageChangeListener {
//
//        // 配合Adapter的currentItem字段进行设置。
//        @Override
//        public void onPageSelected(int position) {
//            mHandler.sendMessage(Message.obtain(mHandler, ImageHandler.MSG_PAGE_CHANGED, position, 0));
//        }
//
//        @Override
//        public void onPageScrolled(int position, float arg1, int arg2) {
//        }
//
//        // 覆写该方法实现轮播效果的暂停和恢复
//        @Override
//        public void onPageScrollStateChanged(int state) {
//            switch (state) {
//                case ViewPager.SCROLL_STATE_DRAGGING:
//                    mHandler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
//                    break;
//                case ViewPager.SCROLL_STATE_IDLE:
//                    mHandler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//    private class ImageAdapter extends PagerAdapter {
//        private List<ImageView> viewlist;
//
//        public ImageAdapter(List<ImageView> viewlist) {
//            this.viewlist = viewlist;
//        }
//
//        @Override
//        public int getCount() {
//            // 设置成最大，使用户看不到边界
//            return Integer.MAX_VALUE;
//        }
//
//        @Override
//        public boolean isViewFromObject(View arg0, Object arg1) {
//            return arg0 == arg1;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            // Warning：不要在这里调用removeView
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            // 对ViewPager页号求模取出View列表中要显示的项
//            position %= viewlist.size();
//            if (position < 0) {
//                position = viewlist.size() + position;
//            }
//            ImageView view = viewlist.get(position);
//            // 如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
//            ViewParent vp = view.getParent();
//            if (vp != null) {
//                ViewGroup parent = (ViewGroup) vp;
//                parent.removeView(view);
//            }
//            container.addView(view);
//            // 此处可添加监听事件
//            return view;
//        }
//    }
//
//    private static class ImageHandler extends Handler {
//        /**
//         * 请求更新显示的View。
//         */
//        protected static final int MSG_UPDATE_IMAGE = 1;
//        /**
//         * 请求暂停轮播。
//         */
//        protected static final int MSG_KEEP_SILENT = 2;
//        /**
//         * 请求恢复轮播。
//         */
//        protected static final int MSG_BREAK_SILENT = 3;
//        /**
//         * 记录最新的页号，当用户手动滑动时需要记录新页号，否则会使轮播的页面出错。
//         * 例如当前如果在第一页，本来准备播放的是第二页，而这时候用户滑动到了末页，
//         * 则应该播放的是第一页，如果继续按照原来的第二页播放，则逻辑上有问题。
//         */
//        protected static final int MSG_PAGE_CHANGED = 4;
//
//        // 轮播间隔时间
//        protected static final long MSG_DELAY = 3000;
//
//        //         使用弱引用避免Handler泄露.这里的泛型参数可以不是Activity，也可以是Fragment等
//        private WeakReference<MainActivity> weakReference;
//        private int currentItem = 0;
//
//        // private boolean isOnce = true;
//
//        protected ImageHandler(WeakReference<MainActivity> wk) {
//            weakReference = wk;
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            final MainActivity mainActivity = weakReference.get();
//            if (mainActivity == null) {
//                // Activity已经回收，无需再处理UI了
//                return;
//            }
//            // 第一次不删重复的消息
//            if (currentItem != 0) {
//                // 检查消息队列并移除未发送的消息，这主要是避免在复杂环境下消息出现重复等问题。
//                if (mainActivity.mHandler.hasMessages(MSG_UPDATE_IMAGE)) {
//                    mainActivity.mHandler.removeMessages(MSG_UPDATE_IMAGE);
//                }
//            }
//            switch (msg.what) {
//                case MSG_UPDATE_IMAGE:
//                    currentItem++;
//                    mainActivity.mViewPager.setCurrentItem(currentItem);
//                    // 准备下次播放
//                    mainActivity.mHandler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
//                    break;
//                case MSG_KEEP_SILENT:
//                    // 只要不发送消息就暂停了
//                    break;
//                case MSG_BREAK_SILENT:
//                    mainActivity.mHandler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
//                    break;
//                case MSG_PAGE_CHANGED:
//                    // 记录当前的页号，避免播放的时候页面显示不正确。
//                    int position = msg.arg1;
//                    int lastIndex = 0;
//                    int index = position % mainActivity.mImageList.size();
//                    for (int i = 0; i < mainActivity.mDotList.size(); i++) {
//                        mainActivity.mDotList.get(i).setBackgroundResource(R.drawable.raidobox);
//                    }
//                    if (mainActivity.mDotList.get(index) != null) {
//                        mainActivity.mDotList.get(index).setBackgroundResource(R.drawable.raidobox_selectedrai);
//                    }
//                    lastIndex = index;
//                    currentItem = position;
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
}