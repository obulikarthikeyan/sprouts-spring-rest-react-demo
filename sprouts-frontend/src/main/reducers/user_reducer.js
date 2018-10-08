const actionTypes = require('../constants/action_types');

const userStore = [];

export default (state = userStore, action) => {
    switch(action.type) {
        case actionTypes.GET_USERS_ACTION_TYPE:
            return action.users;
    }
};