import { takeEvery } from "redux-saga/effects";
import { REGISTERREQUEST } from "./ActionType";

interface Action {
  type: string;
  payload: string;
}

function* registerUser(action: Action) {
  console.log(action);
}

function* registerSaga() {
  yield takeEvery(REGISTERREQUEST, registerUser);
}

export default registerSaga;
