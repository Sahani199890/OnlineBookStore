import {
  REGISTERREQUEST,
  REGISTERREQUESTFAILURE,
  REGISTERREQUESTSUCCESS,
} from "./ActionType";

interface InitialState {
  loading: boolean;
  error: string | null;
  success: string | null;
}

interface Action {
  type: string;
  payload?: string | null; // Payload can be undefined or null
}

const initialState: InitialState = {
  loading: false,
  success: null,
  error: null,
};

const RegisterReducer = (
  state = initialState,
  action: Action
): InitialState => {
  switch (action.type) {
    case REGISTERREQUEST:
      return { ...state, loading: true, error: null, success: null }; // Reset success and error
    case REGISTERREQUESTSUCCESS:
      return {
        ...state,
        loading: false,
        success: action.payload ?? "Registration successful", // Handle undefined payload
        error: null,
      };
    case REGISTERREQUESTFAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload ?? "Registration failed", // Provide default error
        success: null, // Clear any success messages
      };
    default:
      return state;
  }
};

export default RegisterReducer;
