/*
 * Copyright Txus Ballesteros 2016 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package com.mvvn.vitaliy.sometask.presentation.main.decky_cards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.mvvn.vitaliy.sometask.R;

public class SlidingDeckAdapter extends ArrayAdapter<SlidingDeckModel> {

    private int elevation;

    public SlidingDeckAdapter(Context context, int elevation) {
        super(context, R.layout.sliding_item);
        this.elevation = elevation;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sliding_item, parent, false);
        }
        SlidingDeckModel item = getItem(position);
        view.setTag(item);
        final View completeView = view.findViewById(R.id.completeCommand);
        final CardView rooot = view.findViewById(R.id.ll_root);
        rooot.setCardElevation((float) elevation);
        completeView.setTag(view);

        completeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SlidingDeck slidingDeck = (SlidingDeck) parent;
                slidingDeck.swipeItem((View) view.getTag(), new SlidingDeck.SwipeEventListener() {
                    @Override
                    public void onSwipe(SlidingDeck parent, View item) {
                        final SlidingDeckModel slidingDeckModel = (SlidingDeckModel) item.getTag();

                    }
                });
            }
        });


        return view;
    }
}
