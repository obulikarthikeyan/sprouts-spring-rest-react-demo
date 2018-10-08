import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import UserList from '../components/user_list';

const AppRouter = () => (
    <BrowserRouter>
        <div className='container'>
            <Switch>
                <Route path="/" component={UserList} exact={true} />
            </Switch>
        </div>
    </BrowserRouter>
);

export default AppRouter;