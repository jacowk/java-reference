//package za.co.reference.enumstuff.enumstatemachine;
//
///*
// * http://www.javacodegeeks.com/2011/07/java-secret-using-enum-to-build-state.html
// * 
// * What you can do with all these techniques is to create a enum based statement.
//
//In this short example, a parser state machine processes raw XML from a ByteBuffer. Each state has its own 
//process method and if there is not enough data available, the state machine can return to retrieve more data. 
//Each transition between states is well defined and the code for all states is together in one enum.
//
// */
//enum States implements State{
//	
//	XML {
//		public boolean process(Context context){
//			if (context.buffer().remaining() < 16) return false;
//			// read header
//			if (headerComplete)
//				context.state(States.ROOT);
//			return true;
//		}
//		
//		private boolean headerComplete = false;
//	}, 
//	ROOT {
//		public boolean process(Context context){
//			if (context.buffer().remaining() < 8) return false;
//			// read root tag
//			if (rootComplete)
//				context.state(States.IN_ROOT);
//			return true;
//		}
//		
//		private boolean rootComplete = false;
//	}
//	
//}