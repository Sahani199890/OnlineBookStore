import { combineReducers } from "@reduxjs/toolkit";
import LoginReducer from "./login/Reducer";
import RegisterReducer from "./register/Reducer";
import { booksReducer } from "./books/Reducer";

// Correct the rootReducer
const rootReducer = combineReducers({
  loginReducer: LoginReducer,
  registerReducer: RegisterReducer,
  booksReducer: booksReducer,
});

export type RootState = ReturnType<typeof rootReducer>;

export default rootReducer;
