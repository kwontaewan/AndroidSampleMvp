package mobidoo.co.kr.androidmvpsample.view.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobidoo.co.kr.androidmvpsample.R;
import mobidoo.co.kr.androidmvpsample.adapter.ImageAdapter;
import mobidoo.co.kr.androidmvpsample.view.main.di.DaggerMainActivityComponent;
import mobidoo.co.kr.androidmvpsample.view.main.di.MainActivityModule;
import mobidoo.co.kr.androidmvpsample.view.main.presenter.MainContract;
import mobidoo.co.kr.androidmvpsample.view.main.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainContract.View {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    ImageAdapter imageAdapter;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule(this,this)).build().inject(this);

        //imageAdapter = new ImageAdapter(this);
        recyclerView.setAdapter(imageAdapter);

        //mainPresenter = new MainPresenter();
        //mainPresenter.attachView(this);


        //mainPresenter.setSampleImageData(SampleImageRepository.getInstance());
        mainPresenter.setImageAdapterModel(imageAdapter);
        mainPresenter.setImageAdapterView(imageAdapter);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(linearLayoutManager);
        mainPresenter.loadItems(this,false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reload) {
            mainPresenter.loadItems(this,true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
    }
}
