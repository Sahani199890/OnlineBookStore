import createSagaMiddleware from "redux-saga";
import { configureStore } from "@reduxjs/toolkit";
import rootReducer from "./RootReducer";
import rootSaga from "./RootSaga";

const sagaMiddleware = createSagaMiddleware();
const configure = configureStore({
  reducer: rootReducer,
  middleware: (getMiddleware) => getMiddleware().concat(sagaMiddleware),
});
sagaMiddleware.run(rootSaga);

export default configure;
