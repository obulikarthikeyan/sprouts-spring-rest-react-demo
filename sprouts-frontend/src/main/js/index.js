import React from 'react';
import ReactDOM from 'react-dom';
import AppRouter from '../routers/router';
import getAppStore from '../store/store';
import { getUsers } from '../actions/user_action';

import { Provider } from 'react-redux';

const store = getAppStore();

const template = (
    <Provider store={store}>
        <AppRouter />
    </Provider>
);

store.dispatch(getUsers()).then(() => {
    ReactDOM.render(template, document.getElementById('react'));
});