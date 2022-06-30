//Importando Componentes do React-Native
import {
  View,
  TouchableOpacity,
  Text,
  FlatList,
  Alert,
} from "react-native";

//Importando Ícones do MaterialIcons do react-native-vector-icons
import Icon from "react-native-vector-icons/MaterialIcons";

//Importando  styles
import styles from "../styles/SHistorico";

export default function Historico({navigation}) {
  return (
    <View style={styles.container}>
      <TouchableOpacity style={styles.botaoTop}  onPress={() => {
            navigation.goBack()
          }}>
     
        <Icon name="arrow-back" color="white" size={30} />
      </TouchableOpacity>
      <Text style={styles.title}>Histórico</Text>
      <View style={styles.containerList}>
        <FlatList
          data={[
            { key: "Remédio" },
            { key: "Remédio0" },
            { key: "Remédio1" },
            { key: "Remédio2" },
            { key: "Remédio3" },
            { key: "Remédio4" },
            { key: "Remédio5" },
            { key: "Remédio6" },
            { key: "Remédio7" },
            { key: "Remédio8" },
            { key: "Remédio9" },
            { key: "Remédio01" },
            { key: "Remédio02" },
          ]}
          renderItem={({ item }) => (
            <View style={styles.viewList}>
              <View style={styles.viewRemedio}>
                <TouchableOpacity
                  style={styles.icon}
                  onPress={() => {
                    Alert.alert("Excluído", "Lembrete excluido com sucesso!!");
                  }}
                >
                  <Text>
                    <Icon
                      name="history"
                      color="#868684"
                      size={25}
                    />
                  </Text>
                </TouchableOpacity>
              </View>
              <Text>
                {item.key} {"\n"}3:00 PM
              </Text>
              <Text style={styles.text2}>10/04/2022</Text>
            </View>
          )}
        ></FlatList>
      </View>
    </View>
  );
}
