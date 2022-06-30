import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  containerList: {
    flex: 0.9,
    justifyContent: "center",
    alignItems: "center",
    width: "82%",
    borderRadius: 30,
    marginTop: 15,
    marginBottom: 30,
  },
  viewList: {
    width: 270,
    margin: 5,
    backgroundColor: "#e9eaec",
    padding: 5,
    borderRadius: 8,
    flexDirection: "row",
  },
  viewRemedio: {
    alignSelf: "center",
  },
  title: {
    marginTop: 15,
    fontSize: 29,
    alignSelf: "flex-start",
    fontWeight: "700",
    marginLeft: 30,
    color: "#212529",
  },
  icon: {
    marginRight: 8,
  },
  text2: {
    alignSelf: "flex-end",
  },
  botaoTop: {
    justifyContent: "center",
    backgroundColor: "#212529",
    alignSelf: "flex-start",
    marginTop: 10,
    marginLeft: 20,
    borderRadius: 10,
    padding: 14.2,
    elevation: 2,
  },
});

export default styles;
