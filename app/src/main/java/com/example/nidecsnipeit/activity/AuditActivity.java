package com.example.nidecsnipeit.activity;

import android.os.Bundle;

import com.example.nidecsnipeit.R;

public class AuditActivity extends BaseActivity {
@Override
protected void onCreate(Bundle saveInstanceState) {
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_audit);
    setupActionBar("AUDIT");
}
}