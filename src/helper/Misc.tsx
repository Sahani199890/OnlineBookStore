export const convertToBase64 = (data: string) => {
  try {
    return btoa(data);
  } catch (error) {
    console.error("Error converting to Base64:", error);
    return null;
  }
};
