/*
 * Copyright (c) 2015 PocketHub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pockethub.core.gist;

import android.accounts.Account;
import android.content.Context;
import android.util.Log;

import com.alorma.github.sdk.bean.dto.response.Gist;
import com.github.pockethub.accounts.AuthenticatedUserTask;
import com.github.pockethub.api.StarGistClient;

/**
 * Task to star a {@link Gist}
 */
public class StarGistTask extends AuthenticatedUserTask<Gist> {

    private static final String TAG = "StarGistTask";

    private final String id;

    /**
     * Create task to star a {@link Gist}
     *
     * @param context
     * @param id
     */
    public StarGistTask(final Context context, final String id) {
        super(context);

        this.id = id;
    }

    @Override
    public Gist run(Account account) throws Exception {
        StarGistClient client = new StarGistClient(id);
        client.observable().toBlocking().first();
        return null;
    }

    @Override
    protected void onException(Exception e) throws RuntimeException {
        super.onException(e);

        Log.d(TAG, "Exception starring gist", e);
    }
}
