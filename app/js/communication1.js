import React from 'react';
import {
  StyleSheet,
  Text,
  View
} from 'react-native';

const HelloWorld = () => {
  return (
    <View style={styles.container}>
      <View style={styles.card}>
        <Text style={styles.hello}>我是 Rn 介面 (Functional)</Text>
        <Text style={styles.subtitle}>Modern Visual Polish</Text>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
    backgroundColor: '#F8F9FA'
  },
  card: {
    backgroundColor: '#FFFFFF',
    padding: 24,
    borderRadius: 20,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 10 },
    shadowOpacity: 0.1,
    shadowRadius: 15,
    elevation: 8,
    width: '100%',
    alignItems: 'center',
    borderLeftWidth: 5,
    borderLeftColor: '#6200EE'
  },
  hello: {
    fontSize: 22,
    fontWeight: '700',
    color: '#212121',
  },
  subtitle: {
    fontSize: 14,
    color: '#757575',
    marginTop: 4,
    textTransform: 'uppercase',
    letterSpacing: 1
  }
});

export default HelloWorld;