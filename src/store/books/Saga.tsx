import { call, put, takeEvery } from "redux-saga/effects";
import {
  GET_ONLINE_BOOK,
  GET_ONLINE_BOOK_SUCCESS,
  GET_ONLINE_BOOKS_FAILURE,
  ONLINE_BOOKS_LIST,
  ONLINE_BOOKS_LIST_FAILURE,
  ONLINE_BOOKS_LIST_SUCCESS,
  SEARCH_DATA,
  SEARCH_DATA_FAILURE,
  SEARCH_DATA_SUCCESS,
} from "./ActionType";

interface Action {
  payload: Payload;
  type: string;
}

interface Payload {
  bookId: string;
}

function* getBooksList(): Generator<any, void, Response> {
  try {
    const response: Response = yield call(
      fetch,
      "http://localhost:8082/books/list-books"
    );

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data: any = yield response.json();
    yield put({ type: GET_ONLINE_BOOK_SUCCESS, payload: data });
  } catch (error) {
    console.error("Error fetching books list:", error);
    yield put({ type: GET_ONLINE_BOOKS_FAILURE, payload: error });
  }
}

function* getOneBook(action: Action): Generator<any, void, Response> {
  console.log(action);

  try {
    const response: Response = yield call(
      fetch,
      `http://localhost:8082/books/${action.payload}`
    );

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data: any = yield response.json();

    yield put({ type: GET_ONLINE_BOOK_SUCCESS, payload: data });
  } catch (error) {
    yield put({ type: GET_ONLINE_BOOKS_FAILURE, payload: error });
  }
}
function* getDataBySearch(action: Action): Generator<any, void, Response> {
  try {
    const response = yield call(
      fetch,
      `http://localhost:8082/books/fetch-input-search/${action.payload}`
    );
    const data = yield response.json();
    yield put({ type: SEARCH_DATA_SUCCESS, payload: data });
  } catch (error) {
    yield put({ type: SEARCH_DATA_FAILURE, payload: error });
  }
}

function* booksSaga(): Generator {
  yield takeEvery(ONLINE_BOOKS_LIST, getBooksList);
  yield takeEvery(SEARCH_DATA, getDataBySearch);
  yield takeEvery(GET_ONLINE_BOOK, getOneBook);
}

export default booksSaga;
