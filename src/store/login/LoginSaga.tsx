import { call, takeEvery } from "redux-saga/effects";
import { LOGINREQUEST } from "./ActionType";

function* loginUser(action: any) {
  console.log(action);

  try {
    const response: Response = yield call(
      fetch,
      "http://localhost:8080/user/login",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(action.payload),
      }
    );
    const data: JSON = yield response.json();

    if (response.ok) {
      console.log("Login successful", data);
    } else {
      console.log("Login failed", data);
    }
  } catch (error) {
    console.error("Error during login", error);
  }
}

export function* loginSaga() {
  yield takeEvery(LOGINREQUEST, loginUser);
}
