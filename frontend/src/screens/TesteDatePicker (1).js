// App.js
import React, { useState } from "react";
import { StyleSheet, View, Text, Button, Platform } from "react-native";

import DateTimePicker from "@react-native-community/datetimepicker";

const TesteDatePicker = () => {
  const [isPickerDateShow, setIsPickerDateShow] = useState(false);
  const [isPickerTimeShow, setIsPickerTimeShow] = useState(false);
  const [date, setDate] = useState(new Date(Date.now()));

  const showPickerDate = () => {
    setIsPickerDateShow(true);
  };

  const showPickerTime = () => {
    setIsPickerTimeShow(true);
  };

  const onChange = (event, value) => {
    setDate(value);
    if (Platform.OS === "android") {
      setIsPickerDateShow(false);
    }
  };

  const onChangeTime = (event, value) => {
    setDate(value);
    if (Platform.OS === "android") {
      setIsPickerTimeShow(false);
    }
  };
  //let formatTeste = `${date.toLocaleDateString('pt-BR')}`
  let formatDate = `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`;
  let formatTime = `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;

  return (
    <View style={styles.container}>
      {/* Display the selected date */}
      <View style={styles.pickedDateContainer}>
        <Text style={styles.pickedDate}>{formatDate}</Text>
      </View>
      <View style={styles.pickedDateContainer}>
        <Text style={styles.pickedDate}>{formatTime}</Text>
      </View>

      {/* The button that used to trigger the date picker */}
      {!isPickerDateShow && (
        <View style={styles.btnContainer}>
          <Button title={formatDate} color="purple" onPress={showPickerDate} />
        </View>
      )}

      {!isPickerTimeShow && (
        <View style={styles.btnContainer}>
          <Button title="Show Picker" color="purple" onPress={showPickerTime} />
        </View>
      )}

      {/* The date picker */}
      {isPickerDateShow && (
        <DateTimePicker
          value={date}
          mode={"date"}
          display={Platform.OS === "ios" ? "spinner" : "default"}
          is24Hour={true}
          onChange={onChange}
          style={styles.datePicker}
        />
      )}

      {/* The date picker */}
      {isPickerTimeShow && (
        <DateTimePicker
          value={date}
          mode={"time"}
          display={Platform.OS === "ios" ? "spinner" : "default"}
          is24Hour={true}
          onChange={onChangeTime}
          style={styles.datePicker}
        />
      )}
    </View>
  );
};

// Kindacode.com
// just add some styles to make our app look more beautiful
// This is not the focus of this article
const styles = StyleSheet.create({
  container: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    flex: 1,
    justifyContent: "center",
    padding: 50,
  },
  pickedDateContainer: {
    padding: 20,
    backgroundColor: "#eee",
    borderRadius: 10,
  },
  pickedDate: {
    fontSize: 18,
    color: "black",
  },
  btnContainer: {
    padding: 30,
  },
  // This only works on iOS
  datePicker: {
    width: 320,
    height: 260,
    display: "flex",
    justifyContent: "center",
    alignItems: "flex-start",
  },
});

export default TesteDatePicker;
