import {
  LOGINREQUEST,
  LOGINREQUESTFAILURE,
  LOGINREQUESTSUCCESS,
} from "./ActionType";

interface Action {
  type: string;
  payload?: string | null;
}

interface InitialState {
  loading: boolean;
  success: string | null;
  error: string | null;
}

const initialState: InitialState = {
  loading: false,
  success: null,
  error: null,
};

const LoginReducer = (state = initialState, action: Action): InitialState => {
  switch (action.type) {
    case LOGINREQUEST:
      return { ...state, loading: true, error: null, success: null };
    case LOGINREQUESTSUCCESS:
      return {
        ...state,
        loading: false,
        success: action.payload ?? null,
        error: null,
      };
    case LOGINREQUESTFAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload ?? "Unknown error",
        success: null,
      };
    default:
      return state;
  }
};

export default LoginReducer;
