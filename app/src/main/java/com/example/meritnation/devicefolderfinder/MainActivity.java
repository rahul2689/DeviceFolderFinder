package com.example.meritnation.devicefolderfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mFolderCheckEt;
    private Button mFolderCheckBtn;
    private boolean isFolderExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFolderCheckEt = (EditText) findViewById(R.id.etFolderCheck);
        mFolderCheckBtn = (Button) findViewById(R.id.btnFolderCheck);

        mFolderCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<StorageUtils.StorageInfo> pathList = StorageUtils.getStorageList();
                String path = "";
                for (int i = 0 ; i < pathList.size(); i++){
                    path = pathList.get(i).getPath() + "/" + mFolderCheckEt.getText().toString().trim();
                    File file = new File(path);
                    if(file.exists()){
                        Toast.makeText(MainActivity.this, "Folder Exists At Path::" + path, Toast.LENGTH_SHORT).show();
                        isFolderExists = true;
                        break;
                    }
                }

                if(!isFolderExists){
                    Toast.makeText(MainActivity.this, "Folder Exists At Path::" + path, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
