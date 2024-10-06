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

interface InitialState {
  response: string | null;
  error: string | null;
  loading: boolean;
}

interface Action {
  type: string;
  payload?: string | null;
}

const initialState: InitialState = {
  response: null,
  error: null,
  loading: false,
};

export const booksReducer = (
  state = initialState,
  action: Action
): InitialState => {
  switch (action.type) {
    case ONLINE_BOOKS_LIST:
    case SEARCH_DATA:
    case GET_ONLINE_BOOK:
      return { ...state, loading: true, error: null };
    case ONLINE_BOOKS_LIST_SUCCESS:
    case GET_ONLINE_BOOK_SUCCESS:
    case SEARCH_DATA_SUCCESS:
      return {
        ...state,
        loading: false,
        response: action.payload ?? null,
        error: null,
      };
    case ONLINE_BOOKS_LIST_FAILURE:
    case GET_ONLINE_BOOKS_FAILURE:
    case SEARCH_DATA_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload ?? "Unknown error",
        response: null,
      };
    default:
      return state;
  }
};
