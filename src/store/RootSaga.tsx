import { all } from "redux-saga/effects";
import { loginSaga } from "./login/LoginSaga";
import registerSaga from "./register/RegisterSaga";
import booksSaga from "./books/Saga";

function* rootSaga() {
  yield all([registerSaga(), loginSaga(), booksSaga()]);
}

export default rootSaga;
